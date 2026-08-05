class Solution:
    def trap(self, arr: List[int]) -> int:
        left=0
        right=len(arr)-1
        leftmax=0
        rightmax=0
        water=0
        while left<=right:
            if arr[left]<=arr[right]:
                if arr[left]>=leftmax:
                    leftmax=arr[left]
                else:
                    water+=leftmax-arr[left]    
                left+=1
            else:
                if arr[right]>=rightmax:
                    rightmax=arr[right]
                else:
                    water+=rightmax-arr[right]    
                right-=1  
        return water  