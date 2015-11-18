package com.bcsg.data;

import com.bcsg.card.CreditCard;
import com.bcsg.card.PanType;
import com.bcsg.card.UnknownPanTypeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardPANMasker {

    public CreditCard getMaskedPanCard(CreditCard card) {
        return new CreditCard(card.getBankName(), card.getPan(), getMaskedPan(card.getPan()), card.getExpiryDate());
    }

    public String getMaskedPan(String pan) {
        try {
            PanType panType = getPanType(pan);
            return maskPan(pan, panType.getMask());
        } catch (UnknownPanTypeException e) {
            //this should be replaced with proper logging
            System.err.println("Unknown PAN type, masking all digits.");
            return pan.replaceAll("\\d", "x");
        }
    }

    private PanType getPanType(String pan) throws UnknownPanTypeException {
        char firstDigit = pan.charAt(0);
        List<PanType> allPanTypes = Arrays.asList(PanType.values());
        List<PanType> filteredPans = allPanTypes.stream()
                .filter(panType -> panType.getFirstDigit() == firstDigit)
                .filter(panType -> panType.getMask().length() == pan.length())
                .collect(Collectors.toList());
        if (filteredPans.size() != 1) {
            //passing unmasked PAN in exception message - potential security risk
            throw new UnknownPanTypeException("Unrecognized PAN: " + pan);
        }
        return filteredPans.get(0);
    }

    private String maskPan(String pan, String mask) {
        StringBuilder maskedPan = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == PanType.DIGIT_CODE) {
                maskedPan.append(pan.charAt(i));
            } else {
                maskedPan.append(c);
            }
        }
        return maskedPan.toString();
    }
}

