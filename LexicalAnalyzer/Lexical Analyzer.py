import re

class Parser:
    def __init__(self, input):
        self.tokens = re.split(r"\s+| \w|(:)", input)
        self.tokens = [token for token in self.tokens if token != None and token != '']
        self.current = 0

    def same(self, expected):
        if self.current < len(self.tokens) and self.tokens[self.current] == expected:
            self.current += 1
        else:
            self.error("Expected \"{}\" but found  \"{}\"".format(expected, self.tokens[self.current]))

    def error(self, message):
        print("Syntax Error: " + message)
        exit()

    def named_expression(self):
        expression_tokens = []
        while self.current < len(self.tokens):
            if re.match(r"^(print|:|else|elif)", self.tokens[self.current]):
                break
            expression_tokens.append(self.tokens[self.current])
            self.current += 1
        return ' '.join(expression_tokens)

    def block(self):
        block_tokens = []
        while self.current < len(self.tokens) and self.tokens[self.current] not in ["elif", "else"]:
            block_tokens.append(self.tokens[self.current])
            self.current += 1
        return ' '.join(block_tokens)

    def if_state(self):
        self.same("if")
        self.named_expression()
        self.same(":")
        self.block()
        self.elif_state()

    def elif_state(self):
        if self.current < len(self.tokens) and self.tokens[self.current] == "elif":
            self.same("elif")
            self.named_expression()
            self.same(":")
            self.block()
            self.elif_state()
        elif self.current < len(self.tokens) and self.tokens[self.current] == "else":
            self.else_state()

    def else_state(self):
        self.same("else")
        self.same(":")
        self.block()

    def parse(self):
        self.if_state()
        if self.current == len(self.tokens):
            print("THE CODE SAMPLE IS ACCEPTED- (THE LANGUAGE IS ACCEPTED BY THE GRAMMAR)")
        else:
            self.error("Expected \"EOF\" but found \"{}\"".format(self.tokens[self.current]))


input = "if x < 0 print(\"x is negative\") elif: x == 0: print(\"x is zero\") else print(\"x is positive\")"

parser = Parser(input)

parser.parse()