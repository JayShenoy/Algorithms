import time

start = time.time()

with open('dictionary.txt') as f:
	words = {line.strip('\n') for line in f}

end = time.time()
diff = round(end - start, 1)

print('Time to load dictionary:', diff, 'seconds')
