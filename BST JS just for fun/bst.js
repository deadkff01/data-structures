/**
* @author Dennis Kaffer
*/


var Node = function(data) {
  this.data = data;
  this.left = null;
  this.right = null;
  return this;
};


Node.prototype.show = function(){
  return "Node: "+this.data + " left: "+this.left+" right: "+this.right;
};


Node.prototype.addRec = function(newNode) {
  if(this.data === null) {
    this.data = newNode.data;
    console.log("Inserted " + newNode.data + " to head");
    this.parent = 'root';
    return;
  }
  if(newNode.data <= this.data) {
    if(this.left !== null) {
      this.left.addRec(newNode);
    } else {
      console.log("Inserted " + newNode.data + " to left of " + this.data);
      this.left = newNode;

    }
  } else if(newNode.data > this.data) {
    if(this.right !== null) {
      this.right.addRec(newNode);
    } else {
      console.log("Inserted " + newNode.data + " to right of " + this.data);
      this.right = newNode;

    }

  }
  return;

};


//so.. i am a freak with prototype.. =/
function removeRec(toRemove, tree) {
  if(tree === null) {
    return null;
  }

  if(toRemove.data == tree.data) {
    tree = removeNode(tree);
    return tree;
  }
  if(tree.left !== null) {
    tree.left = removeRec(toRemove, tree.left);
  }
  if(tree.right !== null) {
    tree.right = removeRec(toRemove, tree.right);
  }
  return tree;
}


function removeNode(tree) {
  if(tree.left === null) {
    return tree.right;
  }else if (tree.right === null) {
    return tree.left;
  }
  else {
    var temp = new Node();
    temp = findHighestLeft(tree.left);
    tree.data = temp.data;
    tree.left = removeRec(temp, tree.left);
  }
  return tree;
}


function findHighestLeft(tree) {
  while(tree.right !== null) {
    tree = tree.right;
  }
  return tree;
}


Node.prototype.preOrder = function() {
  console.log(this.data);
  if(this.left !== null) {
    this.left.preOrder();
  }
  if(this.right !== null) {
    this.right.preOrder();
  }
};


var BST = function() {
  this.root = new Node(null);
  this.size = 0;
};


BST.prototype.add = function(newNode) {
  if(newNode instanceof Node) {
    this.root.addRec(newNode);
  } else {
    this.root.addRec(new Node(newNode));
  }
  this.size++;
};


BST.prototype.isEmpty = function() {
  return this.root.data === null;
};


BST.prototype.remove = function (toRemove) {
  if(!this.isEmpty()) {
    try {
      console.log('remove: '+toRemove.data);
      //ill try solve this with prototype another day..
      if(toRemove instanceof Node){
        this.root = removeRec(toRemove, this.root);
      } else {
        this.root = removeRec(new Node(toRemove), this.root);
      }

    }catch(e) {
      console.log(e);
    }
  } else {
    console.log('Tree is empty!!');
  }
  return;

};


BST.prototype.preOrder = function() {
  this.root.preOrder();
};


x = new BST();
x.add(5);
x.add(1);
x.add(6);
x.add(7);
x.add(2);
x.add(8);
x.remove(new Node(5));
x.remove(8);

x.preOrder();
