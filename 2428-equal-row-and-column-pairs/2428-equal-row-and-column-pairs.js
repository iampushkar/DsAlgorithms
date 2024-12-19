/**
 * @param {number[][]} grid
 * @return {number}
 */
var equalPairs = function (grid) {
    let n = grid.length, rowString = "", colString = "", result = 0
    let rowMap = new Map();

    for (let i = 0; i < n; i++) {
        rowString = ""
        for (let j = 0; j < n; j++) {
            rowString = rowString + grid[i][j] + ","
        }
        if (!rowMap.has(rowString)) {
            rowMap.set(rowString, 1)
        } else {
            rowMap.set(rowString, rowMap.get(rowString) + 1)
        }
    }

    for (let i = 0; i < n; i++) {
        colString = ""
        for (let j = 0; j < n; j++) {
            colString = colString + grid[j][i] + ","
        }
        if (rowMap.has(colString)) {
            result += rowMap.get(colString)
        }
    }
    return result
};