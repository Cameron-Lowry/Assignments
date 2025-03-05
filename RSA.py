import random


class Rsa:
    def __init__(self):
        self.primes = [i for i in range(100, 1000) if self.isPrime(i)]

    def isPrime(self, num):
        if num < 2:
            return False
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                return False
        return True

    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a

    def multiplicativeInverse(self, e, phi):
        d = 1
        while (d * e) % phi != 1:
            d += 1
        return d

    def keyGen(self):
        p = random.choice(self.primes)
        q = random.choice(self.primes)
        while q == p:
            q = random.choice(self.primes)
        n = p * q
        phi = (p - 1) * (q - 1)
        e = random.randint(2, phi - 1)
        while self.gcd(e, phi) != 1:
            e = random.randint(2, phi - 1)
        d = self.multiplicativeInverse(e, phi)
        pu = (e, n)
        pr = (d, n)
        return pu, pr, p, q

    def rsa(self, value, key):
        exponent, n = key
        return pow(value, exponent, n)


class TextConverter:
    def function1(self, word):
        if isinstance(word, str):
            cL = [i for i in word]
            return cL
        else:
            return ''.join(word)

    def function2(self, word):
        if isinstance(word[0], str):
            return [ord(i) for i in word]
        else:
            return [chr(i) for i in word]

    def function3(self, word):
        if isinstance(word[0], str):
            return [bin(ord(i))[2:].zfill(8) for i in word]
        else:
            return ''.join(chr(int(i, 2)) for i in word)


def convert(rsa, textConverter, text, pu, pr):
    cL = textConverter.function1(text)
    aL = textConverter.function2(cL)

    eA = [rsa.rsa(char, pu) for char in aL]
    dA = [rsa.rsa(char, pr) for char in eA]

    eS = ' '.join(str(num) for num in eA)
    dS = ''.join(chr(num) for num in dA)

    return eS, dS


def main():
    rsa = Rsa()
    pu, pr, p, q = rsa.keyGen()
    print("Chosen primes: p=" + str(p) + ", q=" + str(q))
    print("Public Key: " + str(pu))
    print("Private Key: " + str(pr))

    textConverter = TextConverter()


    name = "Cameron Lowry"
    eN, dN = convert(rsa, textConverter, name, pu, pr)
    eNS = ''.join(chr(int(num)) for num in eN.split())
    print("Encrypted name as string: " + eNS)
    print("Decrypted name: " + dN)

    sentence = "The apple is Red"
    eN, dN = convert(rsa, textConverter, sentence, pu, pr)
    eNS = ''.join(chr(int(num)) for num in eN.split())
    print("Encrypted sentence as string: " + eNS)
    print("Decrypted sentence: " + dN)


if __name__ == "__main__":
    main()