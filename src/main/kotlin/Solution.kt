import java.util.*

/**
 * 선분이 겹치는 길이만큼 출력
 */

class Solution {
    fun solution(lines: Array<IntArray>): Int {
        var answer: Int = 0
        val map = mutableMapOf<Int,Int>()
        val range = (-100..100)

        //데이터 입력
        range.forEach {
            map[it] = 0
        }

        //데이터 확인후 true 로변경
        lines.forEach{line->
            val lineRange = (line[0]..line[1])
            lineRange.forEach{
                map[it] = map[it]!! + 1
            }
        }
        //길이를 구해야하므로
        val checkedLine = map.filter{it.value>=2}

        //연속적으로 이루어져야한다 -> Stack?
        val stack = Stack<Int>()
        var count = 0
        checkedLine.forEach{
            if(stack.isEmpty()) {
                stack.push(it.key)
                count = 0
            }
            else{
                if(stack.peek()==it.key-1) {
                    stack.push(it.key)
                    count++
                }
                else {
                    stack.pop()

                }
            }
        }
        answer = count
        return answer
    }
}

fun main() {

    Solution().solution(
        arrayOf(
            intArrayOf(4, 7),
            intArrayOf(4, 5),
            intArrayOf(6, 7)
        )
    )//2

    Solution().solution(
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 5),
            intArrayOf(3, 9)
        )
    )//2

    Solution().solution(
        arrayOf(
            intArrayOf(-1, 1),
            intArrayOf(1, 3),
            intArrayOf(3, 9)
        )
    )//0

    Solution().solution(
        arrayOf(
            intArrayOf(0, 5),
            intArrayOf(3, 9),
            intArrayOf(1, 10)
        )
    )//8


}