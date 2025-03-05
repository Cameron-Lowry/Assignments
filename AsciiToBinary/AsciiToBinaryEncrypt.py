class TextConverter:

    def function1(self, word):
        if (isinstance(word, str)):
            array = []

            for i in word:
                array.extend(i)

            print("The character list is: ", array)
            return word

        else:
            s = ""
            for i in word:
                s += i
            print("The String is: ", s)
            return word

    def function2(self, word):


        if isinstance(word[1], str) == True:
            word = [ord(i) for i in word]

            print("The ASCII list is: ", word)
            return word

        else:
            word = [chr(i) for i in word]
            print("The character list is: ", word)
            return word

    def function3(self, word):

        if isinstance(word[1], str) == True:
            for i in range(len(word)):
                word[i] = int(word[i], 2)

            print("The ASCII list is: ", word)
            return word
        else:
            word = [bin(i)[2:] for i in word]
            print("The Binary list is: ", word)
        return word

text = TextConverter

name = []

previous = text.function3(text, text.function2(text, text.function1(text, input("Input your first and last name to be "
                                                                                "converted too binary\n"))))

input("continue?")
print("Binary String of name is ", previous)
print("Converting back too String")
text.function1(text, text.function2(text, text.function3(text, previous)))

input("continue?")

previous = text.function3(text, text.function2(text, text.function1(text, input("Input a sentence to be converted "
                                                                     "too binary\n"))))

input("Continue?")
print("Binary String of sentence is " , previous)
print("Converting back too String")

text.function1(text, text.function2(text, text.function3(text, previous)))