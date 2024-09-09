print("welcome to my quiz!")

playing = input("do you want to play? ")

if playing.lower() != "yes":
    quit()

print("okay! let's play :)")
score = 0

answer = input("whats CPU stands for? ")
if answer.lower() == "central processing unit":
    print("correct!")
    score += 1
else:
    print("wrong!")

answer = input("whats GPU stands for? ")
if answer.lower() == "graphics processing unit":
    print("correct!")
    score += 1
else:
    print("wrong!")

answer = input("whats RAM stands for? ")
if answer.lower() == "random access memory":
    print("correct!")
    score += 1
else:
    print("wrong!")

print("you got " + str(score) + " question correct!")