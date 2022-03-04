/*
Runtime: 52 ms, faster than 99.76% of TypeScript online submissions for Length of Last Word.

Memory Usage: 43.9 MB, less than 5.65% of TypeScript online submissions for Length of Last Word.
*/
function lengthOfLastWord(s: string): number {
    const trimmedStr = s.trim();
    let i = trimmedStr.length-1;
    let count = 0;
    while (trimmedStr[i] && trimmedStr[i] !== ' ') {
        i -= 1;
        count += 1;
    }
    return count;
};