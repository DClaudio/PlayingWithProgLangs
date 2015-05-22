def checkio(data):
    for nr in data:
        if data.count(nr) == 1:
            data.remove(nr)
    return data
