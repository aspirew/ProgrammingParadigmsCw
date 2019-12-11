package zad1;

public class zad1{
    public static void main(String[] args) throws FullException, EmptyException {
        MyQueue<String> queue = new CyclicArrayQueue<>(3);
        queue.enqueue("java");
        queue.enqueue("scala");
        queue.enqueue("ocaml");
        System.out.println(queue.first());
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("cpp");
        System.out.println(queue.first());
        queue.dequeue();
        queue.enqueue("python");
        System.out.println(queue.first());
        }
}
