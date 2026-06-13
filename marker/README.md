Marker interface = an interface with no methods, used only to mark/tag a class so that some framework or code can treat those classes differently at runtime. It’s basically metadata via implements, not behavior.

Classic JDK examples: Serializable, Cloneable – they don’t force you to implement any methods, but their presence tells other code “this object can be serialized/cloned”.