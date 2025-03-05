class TextConverter:
    def function1(self, word):
        if isinstance(word, str):
            array = []
            for i in word:
                array.extend(i)
            return array
        else:
            s = ""
            for i in word:
                s += i
            print("The String is: ", s)
            return word

    def function2(self, word):
        if isinstance(word[1], str):
            word = [ord(i) for i in word]
            return word
        else:
            word = [chr(i) for i in word]
            return word

    def function3(self, word):
        if isinstance(word[1], str):
            for i in range(len(word)):
                word[i] = int(word[i], 2)
            return word
        else:
            word = [bin(i)[2:] for i in word]
            return word


def feistel_cipher(input_bits, key):

    L0 = input_bits[:4]
    R0 = input_bits[4:]


    R0_int = int(R0, 2)
    k_int = int(key, 2)


    F_R0_k = (2 * R0_int) ^ k_int
    F_R0_k %= 16


    F_R0_k_bin = format(F_R0_k, '04b')


    L1 = R0
    R1 = bin(int(L0, 2) ^ int(F_R0_k_bin, 2))[2:].zfill(4)  # L0 XOR F(R0, k)


    output = R1 + L1
    return output

text = TextConverter()
input = "Cameron Lowry"
previous = text.function3(text.function2(text.function1(input)))
previousFixed = [bin_str.zfill(8) for bin_str in previous]
key = "1101"

# Process each binary string with feistel_cipher
for i in range(2):  # Only iterate twice
    print("Character", i, "=", previousFixed[i], " key =", key)
    result = feistel_cipher(previousFixed[i], key)
    print("Output after Feistel Cipher for character", i, ":", result)

eR = []

for i in range(len(previousFixed)):
    result = feistel_cipher(previousFixed[i], key)
    eR.append(result)

cR = text.function3(eR)
eR = text.function2(cR)
word = text.function1(eR)

input = "The world is really cool"
previous = text.function3(text.function2(text.function1(input)))
previousFixed = [bin_str.zfill(8) for bin_str in previous]
key = "1101"

# Process each binary string with feistel_cipher
for i in range(2):  # Only iterate twice
    print("Character", i, "=", previousFixed[i], " key =", key)
    result = feistel_cipher(previousFixed[i], key)
    print("Output after Feistel Cipher for character", i, ":", result)

eR = []

for i in range(len(previousFixed)):
    result = feistel_cipher(previousFixed[i], key)
    eR.append(result)

cR = text.function3(eR)
eR = text.function2(cR)
word = text.function1(eR)