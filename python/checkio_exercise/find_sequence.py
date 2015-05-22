def checkio(matrix):
    row_cols = list(map(tuple,matrix)) + list(zip(*matrix))
    diags1 = [[row[i+offset] for i,row in enumerate(matrix) if i+offset in range(len(matrix))] for offset in range(-(len(matrix)-4),len(matrix)-3)]
    diags2 = [[row[-1-i+offset] for i,row in enumerate(matrix) if -1-i+offset in range(-1,-(len(matrix)+1),-1)] for offset in range(-(len(matrix)-4),len(matrix)-3)]
    return list(filter(check_line, row_cols + diags1 + diags2)) != []

def check_line(line):
     return "XXXX" in "".join(map(lambda elem: "X" if line.count(elem)>=4 else "_" ,line))
