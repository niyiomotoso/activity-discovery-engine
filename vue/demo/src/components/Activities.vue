<script>
export default {
  name: "activities-component",
    props: {
        activities: [],
    },
};

</script>

<template>
    <div class="activities-list">

        <div v-if="activities.length === 0" class="no-results">No activities found.</div>

        <div v-else>
            <div v-for="activity in activities" :key="activity.id" class="activity-card">
                <h3>{{ activity.title }}</h3>
                <p>Price: {{ activity.currency }}{{ activity.price }}</p>
                <p>Rating: {{ activity.rating }}</p>
                <p>Supplier: {{ activity.supplierName }}</p>
                <hr>
            </div>
        </div>
    </div>
</template>

<style src="@/styles/activity.css"></style>
