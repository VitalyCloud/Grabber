package ArxivClient.ArxivAPI.Prefix;

public enum PrefixID {
    all {
        @Override
        public String toString() {
            return "All";
        }
    },
    au {
        @Override
        public String toString() {
            return "Author";
        }
    },
    ti {
        @Override
        public String toString() {
            return "Title";
        }
    },
    abs {
        @Override
        public String toString() {
            return "Abstract";
        }
    },
    co {
        @Override
        public String toString() {
            return "Comment";
        }
    },
    id {
        @Override
        public String toString() {
            return "Id";
        }
    },
    jr{
        @Override
        public String toString() {
            return "Journal Reference";
        }
    },
    rn{
        @Override
        public String toString() {
            return "Report Number";
        }
    },
    cat{
        @Override
        public String toString() {
            return "Subject Category";
        }
    }
}