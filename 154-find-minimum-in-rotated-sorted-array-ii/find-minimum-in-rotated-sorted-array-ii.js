/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let min=Number.MAX_VALUE;
     let n=nums.length;
    for(let i=0;i<n;i++){
        if(nums[i]<min){
            min=Math.min(nums[i],min);

        }
    }
      return min;
};