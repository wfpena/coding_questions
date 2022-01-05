function largestRectangleArea(heights: number[]): number {
    if (heights.length < 1 || !heights) return 0;
    let max = heights[0];
    let minToLeft: number[] = [];
    let minToRight: number[] = [];
    minToLeft[0] = -1;
    minToRight[heights.length-1] = heights.length;
    
    for (let i = 1; i < heights.length; i += 1) {
        let p = i-1;
        while (p >= 0 && heights[p] >= heights[i]) {
            p = minToLeft[p];
        }
        minToLeft[i] = p;
    }

    for (let i = heights.length-2; i >= 0; i -= 1) {
        let p = i+1;
        while (p < heights.length && heights[p] >= heights[i]) {
            p = minToRight[p];
        }
        minToRight[i] = p;
    }
    
    for (let i = 0; i < heights.length; i += 1) {
        const area = heights[i] * (minToRight[i] - (minToLeft[i]+1));
        if (max < area) max = area;
    }
    return max;
};