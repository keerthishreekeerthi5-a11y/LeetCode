class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result=set()
        left=0
        max_len=0
        for right in range(len(s)):
            while s[right] in result:
                result.remove(s[left])
                left+=1
            result.add(s[right])
            max_len=max(max_len,right-left+1)
        return max_len        