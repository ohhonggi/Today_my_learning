statement = input().upper()
Alphabet = list(set(statement))
key = []

for i in Alphabet:
    token = statement.count(i)
    key.append(token)

if key.count(max(key)) > 1:
    print('?')
else:
    max_index = key.index(max(key))
    print(Alphabet[max_index])
# if result[len(result)-2] == result[len(result)-1]:
#     print('$')
# else:
#     print(result[len(result)-1])
