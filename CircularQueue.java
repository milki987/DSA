package question1;

public class CircularQueue {

        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public CircularQueue(int capacity) {
            queue = new int[capacity];
            front = -1;
            rear = -1;
            size = 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(int data) {
            if (isFull()) {
                throw new RuntimeException("Queue is full");
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % queue.length;
            queue[rear] = data;
            size++;
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            int data = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
            size--;
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return queue[front];
        }

        public static void main(String[] args) {
            CircularQueue cq = new CircularQueue(5);
            cq.enqueue(1);
            cq.enqueue(2);
            cq.enqueue(3);
            System.out.println(cq.dequeue()); // 1
            System.out.println(cq.peek());    // 2
            cq.enqueue(4);
            cq.enqueue(5);
            cq.enqueue(6);
            System.out.println(cq.dequeue()); // 2
            cq.enqueue(7);
            System.out.println(cq.peek());    // 3
        }
    }



