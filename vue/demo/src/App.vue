<script>
import Activities from './components/Activities.vue'
import {getActivities} from "@/services/activity-service";

export default {
    name: 'App',
    components: {
        Activities
    },
    data() {
        return {
            activities: [],
            searchTerm: '',
        };
    },
    async mounted() {
        const result = getActivities('');
        if (result.status) {
            this.activities = result.data;
        }
    },
    methods: {
        onSubmit: function() {
            const result = getActivities(this.searchTerm);
            if (result.status) {
                console.log(result.data)
                this.activities = result.data;
            }
        }
    },
}
</script>

<template>
    <div id="app">
        <h1>Activities</h1>
        <div class="search-box">
            <input v-model="searchTerm" v-on:keyup.enter="onSubmit" type="text" placeholder="Search activities">
        </div>
        <Activities :activities="activities" />
    </div>
</template>

<style>
#app {
    text-align: center;
    color: #2c3e50;
}
</style>
