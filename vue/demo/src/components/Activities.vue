<script>
export default {
  name: "activities-component",
    props: {
        activities: [],
    },
    methods: {
      specialOffer(specialOffer) {
        if (specialOffer) {
            return "Yes";
        } else {
            return "No";
        }
      }
    }
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
                <p>Has Special Offer: {{ specialOffer(activity.specialOffer) }}</p>
                <hr>
                <p>Event By: {{ activity.supplierName }}</p>
            </div>
        </div>
    </div>
</template>

<style src="@/styles/activity.css"></style>
