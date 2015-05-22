FIRST_TEN = ["one", "two", "three", "four", "five", "six", "seven",
             "eight", "nine"]
SECOND_TEN = ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
              "sixteen", "seventeen", "eighteen", "nineteen"]
OTHER_TENS = ["twenty", "thirty", "forty", "fifty", "sixty", "seventy",
              "eighty", "ninety"]
HUNDRED = [num + " hundred" for num in FIRST_TEN]


def checkio(number):
    digitList = [""]*(3-len(str(number))) + list(str(number))                                                 
    speech = []
    #first digit
    if digitList[0] not in ["","0"]: speech.append(HUNDRED[int(digitList[0])-1])
    #second digit
    if digitList[1] not in ["","0","1" ]: speech.append(OTHER_TENS[int(digitList[1])-2])
    if  digitList[1] == "1": speech.append(SECOND_TEN[int(digitList[2])])
    #third digit
    if digitList[2] not in ["","0"] and digitList[1] != "1": speech.append(FIRST_TEN[int(digitList[2])-1])
 
    return " ".join(speech)





#These "asserts" using only for self-checking and not necessary for auto-testing
assert checkio(4) == 'four', "1st example"
assert checkio(21) == 'twenty one', "2nd example"
assert checkio(12) == 'twelve', "3rd example"
assert checkio(133) == 'one hundred thirty three', "5th example"
assert checkio(212) == 'two hundred twelve', "7th example"

assert checkio(101) == 'one hundred one', "6th example"
assert checkio(40) == 'forty', "4th example"

#assert not checkio(212).endswith(' '), "Don't forget strip whitespaces at the end of string"
