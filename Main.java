
import java.util.Scanner;

class Node {
    int rollNo;
    Node left, right;

    Node(int rollNo) {
        this.rollNo = rollNo;
        left = right = null;
    }
}

public class Main {

    static Node root = null;

    // Insert student roll number
    static Node insert(Node root, int rollNo) {

        if (root == null) {
            return new Node(rollNo);
        }

        if (rollNo < root.rollNo) {
            root.left = insert(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = insert(root.right, rollNo);
        } else {
            System.out.println("Roll number already exists!");
        }

        return root;
    }

    // Search student roll number
    static boolean search(Node root, int rollNo) {

        if (root == null) {
            return false;
        }

        if (root.rollNo == rollNo) {
            return true;
        }

        if (rollNo < root.rollNo) {
            return search(root.left, rollNo);
        }

        return search(root.right, rollNo);
    }

    // Find minimum value node
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete student roll number
    static Node delete(Node root, int rollNo) {

        if (root == null) {
            return null;
        }

        if (rollNo < root.rollNo) {
            root.left = delete(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = delete(root.right, rollNo);
        } else {

            // Node with no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Node with one child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Node with two children
            Node temp = findMin(root.right);
            root.rollNo = temp.rollNo;
            root.right = delete(root.right, temp.rollNo);
        }

        return root;
    }

    // Inorder traversal
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.rollNo + " ");
            inorder(root.right);
        }
    }

    // Preorder traversal
    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.rollNo + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.rollNo + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, rollNo;

        do {
            System.out.println("\n--- Student BST Management ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll Number: ");
                    rollNo = sc.nextInt();

                    if (search(root, rollNo)) {
                        System.out.println("Roll number already exists!");
                    } else {
                        root = insert(root, rollNo);
                        System.out.println("Student inserted successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Search: ");
                    rollNo = sc.nextInt();

                    if (search(root, rollNo)) {
                        System.out.println("Student found!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Delete: ");
                    rollNo = sc.nextInt();

                    if (search(root, rollNo)) {
                        root = delete(root, rollNo);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Inorder Traversal: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder Traversal: ");
                    preorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder Traversal: ");
                    postorder(root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Exiting BST Management System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
