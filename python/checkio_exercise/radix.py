def checkio(number):
    toDigit = lambda x: int(x) if x.isdigit() else ord(x) - 55
    biggestDigit = toDigit(sorted(number)[len(number)-1])
    for radix in range(biggestDigit+1, toDigit("Z")+2):
        toDecimal = sum([elem*(radix**idx) for idx,elem in enumerate(list(map(toDigit,number))[::-1])])
        print("radix:",radix," is:",toDecimal)
        if toDecimal % (radix-1) == 0:
            return radix
    return 0


#These "asserts" using only for self-checking and not necessary for auto-testing
assert checkio("18") == 10, "Simple decimal"
assert checkio("1010101011") == 2, "Any number is divisible by 1"
assert checkio("222") == 3, "3rd test"
assert checkio("A23B") == 14, "It's not a hex"
assert checkio("IDDQD") == 0, "k is not exist"
print('Local tests done')
