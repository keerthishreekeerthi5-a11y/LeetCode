class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        currentsum=nums[0]
        maximumsum=nums[0]
        for num in nums[1:]:
            currentsum=max(num,currentsum+num)
            if currentsum>maximumsum:
                maximumsum=max(maximumsum,currentsum)
        return maximumsum            
        
        