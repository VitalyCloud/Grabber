package ArxivClient.ArxivAPI.Search.Field.Prefix;

public enum PrefixID {
    all,
    author,
    _abstract {
        @Override
        public String toString() {
            return "abstract";
        }
    },
    comment,
    id,
    journalReference{
        @Override
        public String toString() {
            return "journal reference";
        }
    },
    reportNumber{
        @Override
        public String toString() {
            return "report number";
        }
    },
    subjectCategory{
        @Override
        public String toString() {
            return "subject category";
        }
    },
    title
}