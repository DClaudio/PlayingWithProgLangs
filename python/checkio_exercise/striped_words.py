import string
VOWELS = "AEIOUY"
CONSONANTS = "BCDFGHJKLMNPQRSTVWXZ"



def checkio(text):
    word_filter = lambda word: not (word.isdigit() or len(word)==1)
    wordList = list(map(transfrom_word,filter(word_filter,text.translate(str.maketrans(string.punctuation," "*len(string.punctuation))).split() )))
    print(wordList)
    filteredList = list(filter(lambda word: not("CC" in word or "VV" in word or "X" in word),wordList))
    return len(filteredList)

def transfrom_word(word):
    new_word = ""
    for c in word:
        if c.upper() in VOWELS:
            new_word+="V"
        elif c.upper() in CONSONANTS:
            new_word+="C"
        else:
            new_word+="X"
    return new_word

assert checkio("1st 2a ab3er root rate") == 1, "All words are striped"
