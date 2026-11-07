# diamond-rush-deobfuscation

A deobfuscation Diamond Rush game project using kubikaugustyn/predictive-deobfuscator and AI agents to rename fields,
methods and arguments

Yes, I know I said AI, but that's because I created
the [Predictive Deobfuscator](https://github.com/kubikaugustyn/predictive-deobfuscator) Quarkus Java project with a
single goal: to automate reverse engineering of Java games using AI while keeping a clear record of what and why the AI
did and not allowing it to arbitrarily change the code, instead relying on predictive (AST-based) refactoring of the
code. This solves the problem of AI not being able to resolve all usages of a given identifier and prevents it from
modifying the code unintentionally.

## Links

- [Predictive Deobfuscator](https://github.com/kubikaugustyn/predictive-deobfuscator)
- A [human decompilation project](https://github.com/palaceswitcher/Diamond-Rush-Decomp) provided the Java code to get
  started (I myself have made many attempts at doing it in the past)
- My Diamond
  Rush [asset decoding project](https://github.com/kubikaugustyn/diamondRush/tree/main/browser/all_files_new/)
  ([website](https://kubikaugustyn.github.io/diamondRush/browser/all_files_new/))