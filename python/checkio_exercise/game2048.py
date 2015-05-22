def move_right(line):
    for i in range(len(line)-1,-1,-1):
        if line[i] == 0 or line[i-1]==0 or line[i] == line[i-1]:
            line[i]=line[i]+line[i-1]
            line[i-1] = 0
    return line


def add_new(state):
    for i in range(len(state)-1,-1,-1):
        for j in range(len(state[0])-1,-1,-1):
            if state[i][j] == 0:
                state[i][j] = 2
                break


state=[[0, 2, 0, 0],
[0, 0, 0, 0],
[0, 0, 0, 0],
[0, 2, 0, 0]]


assert move_right([0, 2, 0, 0]) == [0, 0, 0, 2], "move_right simple"
assert move_right([0, 2, 0, 2]) == [0, 0, 0, 4], "move_right with add"
assert move_right([2, 2, 0, 2]) == [0, 0, 4, 2], "move_right with 3 identical"

