/*
Runtime: 69 ms, faster than 89.41% of TypeScript online submissions for Length of Last Word.

Memory Usage: 43.5 MB, less than 13.18% of TypeScript online submissions for Length of Last Word.
*/
function lengthOfLastWord(s: string): number {
    const wordArr = s.trim().split(' ');
    return wordArr[wordArr.length-1].length;
};