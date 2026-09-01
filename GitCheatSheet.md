# Git & GitHub Collaboration Cheat Sheet

A practical workflow guide for team assignments to prevent merge conflicts and keep your repository clean.

---

## The Golden Rules of Collaboration

1. **Always `git pull` before you start working.**
2. **Never push directly to `main` without coordinating.**
3. **Commit often in small, logical chunks.**
4. **Communicate when editing the exact same file.**

---

## 1. Initial One-Time Setup

Clone the repository to your local machine:

```bash
git clone <REPOSITORY_URL>
cd <REPOSITORY_FOLDER>
```

Set your Git identity (if not already configured):

```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

## 2. Recommended Branching Workflow (Conflict-Free)

Working directly on `main` at the same time causes the most merge conflicts. Using feature branches keeps your work isolated until it is ready.

```
main (stable shared code)
 └── feature/nico-task-class      --> Pull Request --> Merge to main
 └── feature/parker-main-layout   --> Pull Request --> Merge to main
```

### Step-by-Step Cycle for Every Task:

#### Step 1: Sync your local `main`
Before starting any new task, get the latest code from GitHub:
```bash
git switch main
git pull origin main
```

#### Step 2: Create a new feature branch
Name branches descriptively (e.g., `feature/data-model` or `setup-routing`):
```bash
git switch -c feature/<your-feature-name>
```

#### Step 3: Work and commit locally
Check status and stage changed files:
```bash
# Check modified files
git status

# Stage specific files
git add <filename>

# Or stage all changed files
git add .

# Commit with a clear, concise message
git commit -m "Add JSON parsing logic for rover sensor stream"
```

#### Step 4: Keep your branch updated with `main`
If your teammate merged changes into `main` while you were working:
```bash
git fetch origin
git merge origin/main
```
*(Resolve any minor conflicts locally before pushing.)*

#### Step 5: Push your branch to GitHub
```bash
git push -u origin feature/<your-feature-name>
```

#### Step 6: Open a Pull Request (PR)
1. Go to your repository on GitHub.
2. Click **Compare & pull request**.
3. Let your partner review the code and approve.
4. Click **Merge pull request** and delete the remote branch.

---

## 3. When to Pull vs. When to Push

| Action | When to do it | Command |
| :--- | :--- | :--- |
| **Pull (`git pull`)** | • At the start of every work session<br>• Before creating a new branch<br>• When your teammate notifies you they merged changes | `git pull origin <branch-name>` |
| **Push (`git push`)** | • When a feature/task is complete and tested<br>• At the end of a session so your work is backed up | `git push origin <branch-name>` |

---

## 4. How to Handle Merge Conflicts

Merge conflicts happen when both collaborators edit the **same line** of the **same file** in different commits.

### Steps to Resolve:
1. Run `git status` to see which files are conflicting (marked as `both modified`).
2. Open the conflicting files in your editor (e.g., VS Code).
3. Look for the conflict markers:
   ```text
   <<<<<<< HEAD (Current Change - Your local code)
   let port = 8080;
   =======
   let port = 3000;
   >>>>>>> origin/main (Incoming Change - Teammate's code)
   ```
4. Decide which code to keep (or combine them) and delete the marker lines (`<<<<<<<`, `=======`, `>>>>>>>`).
5. Stage the resolved files and complete the commit:
   ```bash
   git add <resolved-file>
   git commit -m "Resolve merge conflict in port configuration"
   git push
   ```

---

## 5. Daily Quick-Reference Command Table

| Task | Command |
| :--- | :--- |
| Check modified & untracked files | `git status` |
| View commit history | `git log --oneline --graph -n 10` |
| List local & remote branches | `git branch -a` |
| Discard unstaged changes in a file | `git restore <filename>` |
| Temporarily stash uncommitted changes | `git stash` |
| Re-apply stashed changes | `git stash pop` |
| Sync remote branch list | `git fetch --prune` |
