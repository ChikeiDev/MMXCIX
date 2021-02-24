package project.mmxcix.common.permissions;

public enum PermissionNode {

    Admin("admin");

    private static final String prefix = "mmxcix:";

    private String node;

    PermissionNode(String node) { this.node = prefix + node; }

    public String getNode() { return node; }
}
