package tencent50;

import java.util.Stack;

class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        minStack = new Stack<>(); // 辅助栈
    }

    public void push(int x) {
        data.push(x);
        // 出现更小值的时候才更新，使栈顶始终为当前最小值;注意相等时也要更新，否则有多个相同值时会出bug
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = data.pop();
        // 如果弹出的是最小值，那么辅助栈也要跟着出
        if (minStack.peek().equals(top)) {
            minStack.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */