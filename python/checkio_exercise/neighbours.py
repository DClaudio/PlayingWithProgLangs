def count_neighbours(grid, row, col):
    count = 0
    if row == 0:
        rowstart = 0
    else:
        rowstart = row -1
    if col == 0:
        colstart = 0
    else:
        colstart = col -1
    if row == len(grid) -1:
        rowstop = row + 1
    else:
        rowstop = row + 2
    if col == len(grid[0])-1:
        colstop = col + 1
    else:
        colstop = col + 2
    for i in range(rowstart, rowstop):
        for j in range(colstart, colstop):
            print('grid['+ repr(i) + '][' + repr(j)+']')
            if grid[i][j] == 1 and not(i==row and j==col):
                count += 1            
    print('count is: ' + repr(count))
    return count

