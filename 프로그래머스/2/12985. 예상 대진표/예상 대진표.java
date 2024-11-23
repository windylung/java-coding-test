public class Solution
{
    public  int solution(int n, int a, int b)
    {
         int answer = 0;
        a -= 1;
        b -= 1;
        while(a != b){
            System.out.println("a + b = " + a + b);
            answer += 1;
            a /= 2;
            b /= 2;
        }

        return answer;
    }

    
}