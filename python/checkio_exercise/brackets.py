BRACKETS_PAIRS = ["()","[]","{}"]
def checkio(expression):
    onlyBrackets = [c for c in expression if c in "".join(BRACKETS_PAIRS)]
    if len(remove_brackets("".join(onlyBrackets)))!=0:
        return False    
    return True

def remove_brackets(brackets):
    if len(brackets)<2 or len([pair for pair in BRACKETS_PAIRS if pair in brackets]) == 0:
        return brackets
    for pair in BRACKETS_PAIRS:
        brackets=brackets.replace(pair,"")
    return remove_brackets(brackets)
