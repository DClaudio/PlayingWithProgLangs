import math
def checkio(opacity):
    opacity_dif  = 10000
    age = 0    
    while  opacity != opacity_dif:
        age+=1
        if isFib(age):
            opacity_dif -= age
        else:
            opacity_dif += 1
        print("age:",age," opac:",opacity_dif)
    return age

def isFib(number):
    if number == 1:
        return True
    elif math.sqrt(5*number**2+4) % 1 == 0 or math.sqrt(5*number**2-4) % 1 == 0:
        return True
    else:
        return False


assert checkio(10000) == 0, "Newborn"
assert checkio(9999) == 1, "1 year"
assert checkio(9997) == 2, "2 years"
assert checkio(9994) == 3, "3 years"
assert checkio(9995) == 4, "4 years"
assert checkio(9990) == 5, "5 years"
