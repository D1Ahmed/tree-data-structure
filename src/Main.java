class Node{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }

}
class BST{
    Node root=null;
    int NOofNodes=0;

    void insert(int data)
    {
        NOofNodes++;
        Node n=new Node(data);
        Node current=root;
        if(root==null)
        {
            root=n;
        }
        else{
            while (true)
            {
                if(n.data< current.data)
                {
                  if(current.left==null)
                  {
                      current.left=n;
                      break;
                  }
                  else
                  {
                    current=current.left;
                  }
                }
                else if(n.data> current.data)
                {
                   if(current.right==null)
                   {
                       current.right=n;
                       break;
                   }
                   else {
                       current=current.right;
                   }
                }
            }
        }
    }
     void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
// type 2 search:
    /* void search(int val, Node root)
    {
        int found =0;
        if(root!=null)
        {
            if(val==root.data)
            {
                System.out.println("value found");
                found=1;
            }
            else{
                if(val< root.data)
                {
                    if(root.left!=null)
                    {
                        search(val,root.left);
                    }
                } else if (val> root.data) {
                    if(root.right!=null)
                    {
                        search(val,root.right);
                    }
                }
            }

        }

    }

     */

    //Search function without RECURSION

    /*
    void search(int val,Node root)
    {
        Node current=root;
        if(root!=null)
        {
            if(val==root.data)
            {
                System.out.println("value found");
            }
            else {
                int i=0;
                while (i<NOofNodes)
                {
                    if(val<current.data && current.left!=null)
                    {
                        current=current.left;
                        if(current.data==val)
                        {
                            System.out.println("found");
                            break;
                        }
                    }
                   else if(val>current.data && current.right!=null)
                    {
                        current=current.right;
                        if(current.data==val)
                        {
                            System.out.println("found");
                            break;
                        }
                    }
                   i++;
                }
                System.out.println("Not found");

            }
        }
        else {
            System.out.println("tree is khali");
        }
    } */

    Node search(Node root,int val)
    {
     if(root==null)
     {
         return null;
     }
     if(val== root.data)
     {
         return root;
     }
     else if(val< root.data)
     {
        return search(root.left,val);
     }
     else {
       return  search(root.right,val);
     }
    }
    void searchh(Node root,int val)
    {
        Node n;
        n= search(root,val);

        if(n==null || n.data!=val)
        {
            System.out.println("node not found");
        }
        else {
            System.out.println("FOUNDDD");
        }
    }
    void delete(Node root, int val)
    {
        if(root.data==val)
        {
            Node slider=root.left;
            Node parent=slider;

            while(slider.right!=null)
            {
                if(slider.right!=null)
                {
                    parent=slider;
                }
                    slider=slider.right;
            }
            root.data=slider.data;
            parent.right=null;
        }

        else if(val< root.data)
        {
            Node n= search(root.left,val);
            if(n.right!=null)
            {
                Node slider =n;
                Node parent=slider;
                while(slider.right!=null)
                {
                    if(slider.right!=null)
                    {
                        parent=slider;
                    }
                    slider=slider.right;
                }
                n.data=slider.data; //slider is at the max node in the left sub tree;
                parent.right=null;
            }
            else {
                Node slider =root;
                Node parent=slider;
                while(slider.right!=null)
                {
                    if(slider.right!=null)
                    {
                        parent=slider;
                    }
                    slider=slider.right;
                }
                parent.right=null;
            }
        }
        // NOW SEARCH in right sub tree if value to be Del is greater than root.
        // replace the with smalles in its left sub tree
        else if (val> root.data)
        {
            Node n= search(root.right,val);
            if(n.left==null) // if its a leaf node
            { // find parent and delete node
                Node slider = root.right;
                Node parent=slider;
                while(slider.left!=null)
                {
                    if(slider.left!=null)
                    {
                        parent=slider;
                    }
                    slider=slider.left;
                }
                parent.left=null;

            }
            else { // if its from mid

            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BST bst1=new BST();

        bst1.insert(15);
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(5);
        bst1.insert(12);
        bst1.insert(18);
        bst1.insert(25);

        bst1.inorder(bst1.root);
      bst1.searchh(bst1.root,90);

      bst1.delete(bst1.root,18);

        bst1.inorder(bst1.root);


    }
}