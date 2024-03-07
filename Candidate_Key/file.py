from itertools import combinations

def closure(attributes, fds):
    closed_set = set(attributes)

    changed = True
    while changed:
        changed = False
        for fd in fds:
            if set(fd[0]).issubset(closed_set) and not set(fd[1]).issubset(closed_set):
                closed_set.update(fd[1])
                changed = True

    return closed_set

def find_candidate_keys(attributes, fds):
    candidate_keys = []

    for subset_size in range(1, len(attributes) + 1):
        for subset in combinations(attributes, subset_size):
            closure_set = closure(subset, fds)
            if closure_set == set(attributes):
                candidate_keys.append(subset)

    return candidate_keys

# Example usage:
attributes = ['A', 'B', 'C', 'D']
functional_dependencies = [(['A'], ['C']), (['B'], ['A']), (['C'], ['D'])]

candidate_keys = find_candidate_keys(attributes, functional_dependencies)

print("Candidate Keys:")
minLen = 1000
for key in candidate_keys:
    # print(key)
    minLen = min(len(key), minLen)

for key in candidate_keys:
    if len(key) == minLen:
        print(key)