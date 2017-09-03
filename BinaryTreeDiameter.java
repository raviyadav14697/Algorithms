 class BinaryTreeDiameter {

    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(5);

        System.out.println("\nDiameter is ==> " + diameter(root));
    }

    public static int diameter(Node root)
    {
        if(root == null)
            return 0;

        return height(root.left)+height(root.right)+1;
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;

        return 1+Math.max(height(root.left),height(root.right));

    }
}

class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
