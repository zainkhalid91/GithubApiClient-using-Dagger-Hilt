package com.zain.githubclientapp.model

import androidx.recyclerview.widget.DiffUtil

class RepositoryModel : ArrayList<RepositoryModel.RepositoryModelItem>() {
    data class RepositoryModelItem(
        val archive_url: String,
        val assignees_url: String,
        val blobs_url: String,
        val branches_url: String,
        val collaborators_url: String,
        val comments_url: String,
        val commits_url: String,
        val compare_url: String,
        val contents_url: String,
        val contributors_url: String,
        val deployments_url: String,
        val description: String,
        val downloads_url: String,
        val events_url: String,
        val fork: Boolean,
        val forks_url: String,
        val full_name: String,
        val git_commits_url: String,
        val git_refs_url: String,
        val git_tags_url: String,
        val hooks_url: String,
        val html_url: String,
        val id: Int,
        val issue_comment_url: String,
        val issue_events_url: String,
        val issues_url: String,
        val keys_url: String,
        val labels_url: String,
        val languages_url: String,
        val merges_url: String,
        val milestones_url: String,
        val name: String,
        val node_id: String,
        val notifications_url: String,
        val owner: Owner,
        val `private`: Boolean,
        val pulls_url: String,
        val releases_url: String,
        val stargazers_url: String,
        val statuses_url: String,
        val subscribers_url: String,
        val subscription_url: String,
        val tags_url: String,
        val teams_url: String,
        val trees_url: String,
        val url: String
    ) {
        data class Owner(
            val avatar_url: String,
            val events_url: String,
            val followers_url: String,
            val following_url: String,
            val gists_url: String,
            val gravatar_id: String,
            val html_url: String,
            val id: Int,
            val login: String,
            val node_id: String,
            val organizations_url: String,
            val received_events_url: String,
            val repos_url: String,
            val site_admin: Boolean,
            val starred_url: String,
            val subscriptions_url: String,
            val type: String,
            val url: String
        )
    }

    class DiffUtilRepositoriesModelItem :
        DiffUtil.ItemCallback<RepositoryModel.RepositoryModelItem>() {
        override fun areItemsTheSame(
            oldItem: RepositoryModel.RepositoryModelItem,
            newItem: RepositoryModel.RepositoryModelItem
        ): Boolean {
            return newItem.id == oldItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepositoryModel.RepositoryModelItem,
            newItem: RepositoryModel.RepositoryModelItem
        ): Boolean {
            return newItem == oldItem
        }
    }
}