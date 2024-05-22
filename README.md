# wc-todo

[//]: # (ssh root@161.97.105.143 'vim file.txt')

[//]: # ()
[//]: # (ssh -tt root@161.97.105.143 'cat file.txt' < input.txt)

[//]: # ()
[//]: # (ssh -t root@161.97.105.143 'vim file.txt')


The error message "Permission denied (publickey,password)" typically indicates an authentication issue when connecting via SSH. Here are some steps to troubleshoot and resolve the problem:

1. **Check SSH Key**: Ensure that the SSH private key you're using for authentication (`${{ secrets.SSH_PRIVATE_KEY }}`) is correct and associated with the correct GitHub account.

2. **Verify SSH Key Permissions**: Make sure the permissions on your SSH private key file are set correctly. Use the following command to set the correct permissions if needed:

   ```
   chmod 600 /path/to/private_key
   ```

3. **Add SSH Key to SSH Agent**: If you haven't already, add your SSH private key to the SSH agent on your local machine using the following command:

   ```
   ssh-add /path/to/private_key
   ```

4. **Ensure SSH Key is Added to GitHub**: Check that the corresponding public key of your SSH private key is added to your GitHub account under "SSH and GPG keys" in your account settings.

5. **Retry SSH Connection**: After ensuring all the above steps, retry the SSH connection to your server using the `ssh` command directly (not through GitHub Actions) to see if you can connect successfully.

6. **Check SSH Configuration**: Verify that your SSH configuration (`~/.ssh/config`) does not have any conflicting configurations that might interfere with authentication.

7. **Verify GitHub Actions Workflow**: Double-check the GitHub Actions workflow configuration, including the values of `${{ secrets.SSH_USER }}` and `${{ secrets.SSH_HOST }}`, to ensure they are correct.

8. **Review Server Access Permissions**: Ensure that the SSH user (`${{ secrets.SSH_USER }}`) has the appropriate permissions to access the server and perform the necessary actions.

By going through these steps, you should be able to identify and resolve the authentication issue when connecting via SSH in your GitHub Actions workflow.