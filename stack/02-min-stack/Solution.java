static class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    public void push(int val) {
        if (min.isEmpty() || val < min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
        min.pop();
    }

    public int top() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        return min.peek();
    }
}
