package com.automation;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ProductService implements IProductService {
    class Node {
        Product product = new Product();
        Node left, right;
        int key;

        public Node(Product data){
            product = data;
            key = data.getId();
            left = right = null;
        }

    }
    // BST root node
    Node root;

    /* This function traverse the skewed binary tree and
      stores its nodes pointers in vector nodes[] */
    void storeBSTNodes(Node root, Vector<Node> nodes)
    {
        // Base case
        if (root == null)
            return;

        // Store nodes in Inorder (which is sorted
        // order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    /* Recursive function to construct binary tree */
    Node buildTreeUtil(Vector<Node> nodes, int start,
                       int end)
    {
        // base case
        if (start > end)
            return null;

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        /* Using index in Inorder traversal, construct
           left and right subtress */
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    // This functions converts an unbalanced BST to
    // a balanced BST
    Node buildTree(Node root)
    {
        // Store nodes of given BST in sorted order
        Vector<Node> nodes = new Vector<Node>();
        storeBSTNodes(root, nodes);

        // Constucts BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }
    // Constructor for Product Service. =>initial empty tree
    ProductService(){
        root = null;
    }


    //recursive delete function
    Node delete_Recursive(Node root, int key)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (key < root.key)     //traverse left subtree
            root.left = delete_Recursive(root.left, key);
        else if (key > root.key)  //traverse right subtree
            root.right = delete_Recursive(root.right, key);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root)  {
        //initially minval = root
        int minval = root.key;
        //find minval
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    //recursive insert function
    Node insert_Recursive(Node root, Product product) {
        //tree is empty
        if (root == null) {
            root = new Node(product);
            return root;
        }
        //traverse the tree
        if (product.getId() < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, product);
        else if (product.getId() > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, product);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    /*
    void inorder() {
        inorder_Recursive(root);
    }*/

    // recursively traverse the BST
    /*
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }*/


    //Recusive search func.
    Node search_Recursive(Node root, int key)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.key==key)
            return root;
        // val is greater than root's key
        if (root.key > key)
            return search_Recursive(root.left, key);
        // val is less than root's key
        return search_Recursive(root.right, key);
    }

    @Override
    public boolean add(Product product) {
        root = insert_Recursive(root, product);
        //this.buildTree(root);
        return true;
    }

    @Override
    public boolean remove(int productId) {
        root = delete_Recursive(root, productId);
        //this.buildTree(root);
        return true;
    }

    @Override
    public Product search(int productId) {
        root = search_Recursive(root, productId);
        if (root!= null)
            return root.product;
        else
            System.out.println("The product you're looking for is out of stock!");
        return null;
    }

    private void getProductRecursive(Node localRoot, ArrayList<Product> list) {
        if (localRoot.right == null && localRoot.left == null) {
            list.add(localRoot.product);
            return;
        }
        if (localRoot.left != null) getProductRecursive(localRoot.left, list);
        list.add(localRoot.product);
        if (localRoot.right != null) getProductRecursive(localRoot.right, list);
    }

    @Override
    public ArrayList<Product> getProducts() {
        Node localRoot = root;
        ArrayList<Product> list = new ArrayList<>();
        getProductRecursive(localRoot, list);
        return list;
    }

    public List<Product> searchByCategory(ProductCategory category) {
        throw new UnsupportedOperationException();
    }



}