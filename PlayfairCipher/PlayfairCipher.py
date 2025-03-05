#generates a key using the cipher text rules
def generateKey(key):
    key = key.upper().replace("J", "I")

    matrix = [[''] * 5 for _ in range(5)]
    letters = []

    r, c = 0, 0
    for alphabet in key + 'ABCDEFGHIKLMNOPQRSTUVWXYZ':
        if alphabet not in letters:
            matrix[r][c] = alphabet
            letters.append(alphabet)
            c += 1
            if c == 5:
                c = 0
                r += 1
                if r == 5:
                    break
    return matrix

#splits string into several different pairs with replacements of J with and if the string
# is odd or a letter repeated it adds an x
def preprocess(plaintext):

    plaintext = plaintext.upper().replace("J", "I")
    pairs = []
    i = 0
    while i < len(plaintext):
        first = plaintext[i]
        if i + 1 < len(plaintext):
            second = plaintext[i + 1]
        else:
            second = 'X'
            i += 1
        if first == second:
            second = 'X'
        pairs.append(first + second)
        i += 2
    return pairs

#Encryption using playfair logic and returning a list of pairs of chars
def encrypt(kM, pairs):
    ciphertext = []
    for pair in pairs:
        char1, char2 = pair[0], pair[1]
        r1, c1 = findPos(kM, char1)
        r2, c2 = findPos(kM, char2)
        if r1 == r2:
            ciphertext.append(kM[r1][(c1 + 1) % 5] + kM[r2][(c2 + 1) % 5])
        elif c1 == c2:
            ciphertext.append(kM[(r1 + 1) % 5][c1] + kM[(r2 + 1) % 5][c2])
        else:
            ciphertext.append(kM[r1][c2] + kM[r2][c1])
    return ciphertext

# decrypts back to plaintext
def decrypt(kM, pairs):
    plaintext = []
    for pair in pairs:
        char1, char2 = pair[0], pair[1]
        row1, col1 = findPos(kM, char1)
        row2, col2 = findPos(kM, char2)
        if row1 == row2:
            plaintext.append(kM[row1][(col1 - 1) % 5] + kM[row2][(col2 - 1) % 5])
        elif col1 == col2:
            plaintext.append(kM[(row1 - 1) % 5][col1] + kM[(row2 - 1) % 5][col2])
        else:
            plaintext.append(kM[row1][col2] + kM[row2][col1])
    return ''.join(plaintext)

#function to find the position of a char in a matrix
def findPos(kM, char):
    for i in range(5):
        for j in range(5):
            if kM[i][j] == char:
                return i, j



keyWord = "the world"
plaintext = "Cameron Lowry"

kM = generateKey(keyWord)


print("Key Matrix:")
for row in kM:
    print(row)

pairs = preprocess(plaintext)
encrypted = encrypt(kM, pairs)
str = ' '.join(encrypted)
print("Encrypted Text: " + str)
decrypted_text = decrypt(kM, encrypted)
print("Decrypted Text: " + decrypted_text)

plaintext = "The world is a little place"


pairs = preprocess(plaintext)

encrypted = encrypt(kM, pairs)
str = ' '.join(encrypted)
print("Encrypted Text: " + str)

decrypted_text = decrypt(kM, encrypted)
print("Decrypted Text: " + decrypted_text)




