import xlsxwriter
from xlsxwriter.utility import xl_range

str = input('Enter data : ')
if str:  # if line is not empty

    # Create a new workbook and add a worksheet
    workbook = xlsxwriter.Workbook('marks.xlsx')
    worksheet = workbook.add_worksheet('Marks')

    # Format 'Name' column
    worksheet.write('A1', 'Name')
    worksheet.set_column(0, 0, 20)
    i = 1  # lines counter
    maxLength = 1
    while str:  # empty line is 'falsy'
        tokens = str.split(' ')
        maxLength = max(maxLength, len(tokens))  # find max line length
        worksheet.write(i,0, tokens[0])  # writing a name
        tokens.remove(tokens[0])  # remove name from array
        worksheet.write_row(i, 1, map(int, tokens))  # write all marks as ints
        str = input() # read next line
        i += 1

    # formatting 'marks'-block
    worksheet.merge_range(xl_range(0, 1, 0, maxLength-1), 'Marks', workbook.add_format({'align': 'center'}))
    worksheet.set_column(1, maxLength-1, 4)

    # 'Average' column
    worksheet.write(0, maxLength, 'Average')
    for n in range(1, i):  # create formula for each line
        worksheet.write_formula(n, maxLength, '{=AVERAGE(' + xl_range(n, 1, n, maxLength-1)+')}')

    workbook.close()
else:
    print('No data')

# dima 5 4 7 8 9 6 5 4 5 7
# pasha 4 5 7
# vlad 5 5 5 5 4 78 6 5
# lena 2 2 2 5 6 8 7 7 9 9