import types
def min(*args, **kwargs):
    key = kwargs.get("key", lambda x: x)
    if type(args[0]) in [list,str,tuple,range,filter,set,types.GeneratorType] and len(args) ==1: args = args[0]
    if type(args)==set: args = list(args)
    mini = args.__next__() if type(args) in [types.GeneratorType,filter] else args[0]
    for e in args:
        if key(e) < key(mini): mini = e        
    return mini


def max(*args, **kwargs):
    key = kwargs.get("key", lambda x: x)
    if type(args[0]) in [list,str,tuple,range,filter,set,types.GeneratorType,]  and len(args) ==1: args = args[0]
    if type(args)==set: args = list(args)
    maxi = args.__next__() if type(args) in [types.GeneratorType,filter] else args[0]
    for e in args:
        if key(e) > key(maxi): maxi = e    
    return maxi


#These "asserts" using only for self-checking and not necessary for auto-testing
assert max(3, 2) == 3, "Simple case max"
assert min(3, 2) == 2, "Simple case min"
assert max([1, 2, 0, 3, 4]) == 4, "From a list"
assert min("hello") == "e", "From string"
assert max(2.2, 5.6, 5.9, key=int) == 5.6, "Two maximal items"
assert min([[1, 2], [3, 4], [9, 0]], key=lambda x: x[1]) == [9, 0], "lambda key"
