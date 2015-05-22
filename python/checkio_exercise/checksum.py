def checkio(data):
    reversedList = list(data.replace(" ","")[::-1])
    toDigit = lambda x: int(x) if x.isdigit() else ord(x) - 55
    doubleVal = lambda x : sum(divmod(2*x,10))
    number = sum([doubleVal(toDigit(elem)) if idx%2 == 0 else toDigit(elem) for idx,elem in enumerate(reversedList) ])
    return [str(10 - (number%10)),number]


assert (checkio("799 273 9871") == ["3", 67]), "First Test"
