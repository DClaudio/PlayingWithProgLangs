def checkio(food_count):
    pigeon_no = 0
    minute_count = 0
    while food_count > 0:
        minute_count +=1
        pigeon_no = pigeon_no + minute_count
        food_count = food_count - pigeon_no
        #print("mc=",minute_count," fc=",food_count," pn=",pigeon_no)
    if food_count < 0:
        pigeon_no = pigeon_no - minute_count
        if minute_count + food_count > 0:
            pigeon_no = pigeon_no + minute_count + food_count     
    return pigeon_no

assert checkio(0) == 0
assert checkio(1) == 1
assert checkio(2) == 1
assert checkio(3) == 2
assert checkio(4) == 3
assert checkio(5) == 3
    
