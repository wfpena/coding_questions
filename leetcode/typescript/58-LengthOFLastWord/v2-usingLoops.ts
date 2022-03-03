function lengthOfLastWord(s: string): number {
    let i = s.length-1;
    while (s[i] == ' ') i -= 1;
    let count = 0;
    while (s[i] && s[i] != ' ') {
        i -= 1;
        count += 1;
    }
    return count;
};