from itertools import product

def checkio(pattern, image):
    pattern_width, pattern_height = len(pattern), len(pattern[0])
    image_width, image_height = len(image), len(image[0])
    for i,j in itertools.product(range(image_width-pattern_width+1), range(image_height-pattern_height+1)):
            portion = [[elem for l,elem in enumerate(row) if l>=j and l<j+pattern_height] for k,row in enumerate(image) if k>=i and k<i+pattern_width ]
            if portion == pattern:
                incerment_matrix(image,i,j,pattern_width,pattern_height)            
    return image

def incerment_matrix(image,rowIdx,colIdx,pattern_width,pattern_height):
    for i,j in itertools.product(range(rowIdx,rowIdx+pattern_width), range(colIdx,colIdx+pattern_height)):
            image[i][j]+=2




assert checkio([[1, 0], [1, 1]],
               [[0, 1, 0, 1, 0],
                [0, 1, 1, 0, 0],
                [1, 0, 1, 1, 0],
                [1, 1, 0, 1, 1],
                [0, 1, 1, 0, 0]]) == [[0, 3, 2, 1, 0],
                                      [0, 3, 3, 0, 0],
                                      [3, 2, 1, 3, 2],
                                      [3, 3, 0, 3, 3],
                                      [0, 1, 1, 0, 0]]
'''assert checkio([[1, 1], [1, 1]],
               [[1, 1, 1],
                [1, 1, 1],
                [1, 1, 1]]) == [[3, 3, 1],
                                [3, 3, 1],
                                [1, 1, 1]]
assert checkio([[0, 1, 0], [1, 1, 1]],
               [[0, 0, 1, 0, 0, 0, 0, 0, 1, 0],
                [0, 1, 1, 1, 0, 0, 0, 1, 1, 1],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 1, 0, 0, 0, 0],
                [0, 1, 0, 0, 1, 1, 1, 0, 1, 0],
                [1, 1, 1, 0, 0, 0, 0, 0, 1, 1],
                [0, 0, 0, 1, 1, 1, 0, 0, 0, 0],
                [0, 0, 1, 0, 0, 0, 0, 1, 0, 0],
                [0, 1, 1, 0, 0, 0, 1, 1, 1, 0],
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]) == [[0, 2, 3, 2, 0, 0, 0, 2, 3, 2],
                                                     [0, 3, 3, 3, 0, 0, 0, 3, 3, 3],
                                                     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                                                     [0, 0, 0, 0, 2, 3, 2, 0, 0, 0],
                                                     [2, 3, 2, 0, 3, 3, 3, 0, 1, 0],
                                                     [3, 3, 3, 0, 0, 0, 0, 0, 1, 1],
                                                     [0, 0, 0, 1, 1, 1, 0, 0, 0, 0],
                                                     [0, 0, 1, 0, 0, 0, 2, 3, 2, 0],
                                                     [0, 1, 1, 0, 0, 0, 3, 3, 3, 0],
                                                     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]]


'''
